import * as serviceWorker from './serviceWorker';
import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App' // 引入组件
import { createStore } from 'redux';
import Reduce from './reducers/modalReducer'
const store = createStore(Reduce);



const render = () => {
    ReactDOM.render(<App store={store}/>, document.getElementById("root"));
}
render();
store.subscribe(render);
serviceWorker.unregister();
