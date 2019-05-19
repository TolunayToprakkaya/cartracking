import React, { Component } from 'react';
import Navbar from './components/Navbar';
import CarList from './components/CarList';

class App extends Component {
  render() {
    return (
      <div className="App">
        <Navbar></Navbar>
        <CarList></CarList>
      </div>
    );
  }
}

export default App;
