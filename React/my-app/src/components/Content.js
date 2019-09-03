import React ,{ Component } from 'react';
import { HashRouter as Router, Route } from "react-router-dom";
import { hashHistor1y } from 'react-router';
import Menu from "./Menu";
import UserList from "./UserList";
import CarList from "./CarList";

// 路由官方例子 https://reacttraining.com/react-router/web/guides/quick-start
// 定义组件
class Content extends Component{
    render() {
        let menuNames = ["UserManger","WorkManager1","WorkManager2","WorkManager3"];
        return (
            // 组件内用引入组件别名集成组件到当前组件
            // 样式需要用{{}}括起来不能用引号
            // 在组件上添加属性值用{}表达是动态表示，组件内可以this.props.属性名取到
            <Router >
                <div style={{width:'100%'}} > 
                    <div style={{float:"left"}}><Menu menuList={menuNames} /></div>
                    <Route path='/UserManger' component={UserList}/>
                    <Route path='/WorkManager1' component={CarList}/>
                </div>
            </Router>
        );
    }
}
export default Content;
