import React ,{ Component } from 'react';
import Menu from "./Menu";
import List from "./List";

class Content extends Component{
    render() {
        let menuNames = ["UserManger","WorkManager1","WorkManager2","WorkManager3"];
        return (
            <div style={{width:'100%'}} >
                <div style={{float:"left"}}><Menu menuList={menuNames} /></div>
                <div style={{float:"left",marginLeft: "100px"}}><List /></div>
            </div>
        );
    }
}
export default Content;
