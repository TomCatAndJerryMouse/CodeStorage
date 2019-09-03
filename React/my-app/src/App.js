import React ,{ Component }from 'react';
import logo from './logo.svg';
import './App.css';
import Header from './components/Header';
import Content from './components/Content';
import Fooder from './components/Fooder'


class App extends Component {
  render(){
    return (
      <div>
        <div><Header/></div>
        <div><Content/></div>
        <div><Fooder/></div>
      </div>
    );
  }
}

export default App;
