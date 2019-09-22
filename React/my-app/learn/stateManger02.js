// 简单模拟reduxStore原理
// 相当于从一个观察者模式变形而来
// 01实现了redux的基本架构，这里继续变形，拆分合并reducer
const creatStore = function (reducer, initState) {
    let state = initState;
    let linsters = [];
    // 订阅者
    function subscribe(linster) {
        linsters.push(linster);
    }
    // 改变状态 这个函数就相当于reducer的dispatch
    //function changeState(action) {
    function dispatch(action) {
        state = reducer(state, action)
        linsters.forEach((linster) => {
            linster();
        })
    }
    // 获取状态
    function getState() {
        return state;
    }
    return {
        subscribe,
        dispatch,
        getState
    }
}

let initState = {
    counter: {
        count: 0,
    },
    info: {
        name: '前端九部',
        description: '我们都是前端爱好者！'
      }
}
// 计数reducer  将reducer函数修改
function countReducer(state, action) {
    switch (action.type) {
        case 'INCREMENT':
            return {
                ...state,
                count: state.count + 1
            }
        case 'DECREMENT':
            return {
                ...state,
                count: state.count - 1
            }
        default:
            return state;
    }
}

// 计数reducer  将reducer函数修改
function infoReducer(state, action) {
    switch (action.type) {
        case 'SET_NAME':
            return {
                ...state,
                name: action.name
            }
        case 'SET_DESCRIPTION':
            return {
                ...state,
                description: action.description
            }
        default:
            return state;
    }
}
// 编译合并reducer
function combineReducers(reducers) {
    let reducerskeys = Object.keys(reducers);
    return function combine(state = {}, action) {
        /*生成的新的state*/
        const nextState = {}
        console.log(state);
        reducerskeys.forEach((rkey) => {
            const reducer = reducers[rkey];
            /*之前的 key 的 state*/
            const previousStateForKey = state[rkey];
            /*执行 分 reducer，获得新的state*/
            const nextStateForKey = reducer(previousStateForKey, action)
            nextState[rkey] = nextStateForKey
        });
        return nextState;
    }
}

// 创建store初始化
let store = creatStore(combineReducers({ counter: countReducer, info: infoReducer }), initState);

// 绑定订阅者
store.subscribe(
    () => {
        console.log('订阅者1 ')
        console.log(store.getState())
    }
);

// 绑定订阅者
store.subscribe(
    () => {
        console.log('订阅者2 ')
        console.log(store.getState())
    }
);

//store.changeState({ type:'INCREMENT' });
//store.changeState({ type:'DECREMENT' });
// dispatch中传入的对象就相当于action
store.dispatch({ type: 'INCREMENT' });
store.dispatch({ type: 'DECREMENT' });
store.dispatch({ type: 'SET_NAME', name: '前端九部2号' });
