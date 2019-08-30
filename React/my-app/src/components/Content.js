import React ,{ Component } from 'react';
import Menu from "./Menu";
import List from "./List";

// 定义组件
class Content extends Component{
    render() {
        let menuNames = ["UserManger","WorkManager1","WorkManager2","WorkManager3"];
        return (
            // 组件内用引入组件别名集成组件到当前组件
            // 样式需要用{{}}括起来不能用引号
            // 在组件上添加属性值用{}表达是动态表示，组件内可以this.props.属性名取到
            <div style={{width:'100%'}} > 
                <div style={{float:"left"}}><Menu menuList={menuNames} /></div>
                <div style={{float:"left",marginLeft: "100px"}}><List /></div>
            </div>
        );
    }
}
export default Content;
