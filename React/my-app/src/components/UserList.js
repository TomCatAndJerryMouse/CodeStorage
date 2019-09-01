import React ,{ Component } from 'react';
import '../myTable.css'

class List extends Component{

    // 生命周期函数 组件构造函数 
    constructor(props){
        console.log("List Component constructor");
        super(props);
        // 需要将orops里参数绑定到state里才能通过修改state里的数据才能达到数据实时更新到dom
        this.state = {
            datas:props.datas
        }
    }

    //生命周期函数 组件第一次渲染前调用  可以在这里获取服务端数据
    componentWillMount ()
    {
        console.log("List Component componentWillMount");
        // 发送ajx请求获取数据
        let datas = [
            {name:'张三',age:12,addr:'成都'},
            {name:'李四',age:11,addr:'宜宾'},
            {name:'网二',age:122,addr:'字样'},
            {name:'滕毅',age:122,addr:'意大利'},
            {name:'笑死',age:132,addr:'巴塞罗那'},
            {name:'罗苗',age:142,addr:'泸州'},
            {name:'滕旋',age:2,addr:'梁山'}
        ];
        this.setState ({
            datas:datas
        })
    }

    // 生命周期函数 渲染组件调用
    render() {
        console.log("List Component render");
        return (
            <div style={{width:'100%'}}>
                <div className='myTr myTheader'><div>名字</div><div>年龄</div><div>地址</div><div>操作</div></div>
                {this.state.datas.map((data,key)=> 
                    <div id={key} key={key} className='myTr'>
                        <div>{data.name}</div>
                        <div>{data.age}</div>
                        <div>{data.addr}</div>
                        <div>
                            {/* 绑定事件，在没有引入其他组件时，要让事件内对数据改变同事刷新dom需要调用传入this,后面可以穿参数 bind(thin,可以穿参数)*/}
                            <button onClick={this.delet.bind(this,data,key)}>删除</button>
                        </div>
                    </div>)}
            </div>
        );
    }

    // 生命周期函数  组件第一次渲染后调用
    componentDidMount(){
        console.log("List Component componentDidMount");
    }

    // 生命周期函数  组件接受新的peops调用
    componentWillReceiveProps () {
        console.log("List Component componentWillReceiveProps");
    }

    // 生命周期函数 是否要跟新组件返回blooean值
    shouldComponentUpdate () {
        console.log("List Component shouldComponentUpdate");
        return true;
    }

    // 生命周期函数 组件 执行完了以后又会调用reander函数
    componentWillUpdate () {
        console.log("List Component componentWillUpdate");
    }

    //生命周期函数 组件跟新完成后调用
    componentDidUpdate ()
    {
        console.log("List Component componentDidUpdate");
    }

    // 删除事件
    delet(data,index){
        console.log("删除 " + index);
        console.log(data);
        // 通过react提供setState函数跟新state中的数据。从下标为index开始删除数组中的1个
        this.state.datas.splice(index,1);
        this.setState({
            datas:this.state.datas
        })
        console.log("删除后");
        console.log(this.state.datas);
    }

}
export default List;
