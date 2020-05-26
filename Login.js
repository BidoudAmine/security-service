import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import axios from 'axios';
import { Link } from 'react-router-dom';
//import './Create.css' ;
import me from './me.jpg' ;
import avatar from './avatar.png' ;

import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';
import "bootstrap/dist/css/bootstrap.css";
import './manal.css'

import u1 from './u1.jpeg'
import fond from './nurse1.jpg'
import u132 from './u132.png'
import u136 from './u136.png'
import u18 from './u18.svg'

class Login extends Component {

  constructor() {
    super();
    this.state = {
      pic:'' ,

      username: '',
      password: '',

      
    };
  }

// O N    C H A N G E S  ––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––
onChange = (e) => {
  const state = this.state
  state[e.target.name] = e.target.value;
  this.setState(state);
}



//–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––
  onSubmit = (e) => {
    e.preventDefault();

    const {username , password } = this.state;

    axios.post('/login', {username , password })
      .then((result) => {
        this.props.history.push("/")
      });
  }

//–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––
/*
alert2 = (e) => {
      
  if(this.state.nom == "") {
      e.preventDefault() ;
      alert("Nom is required") ;
  }
}

alert1 = (e) => {
      
      if(this.state.prenom == "") {
          e.preventDefault() ;
          alert("Prenom is required") ;
      }
  }
*/

aumed = (e) => {
  e.preventDefault() ;
  alert("Cette fiche est prête pour être remplie par les medecins !") ;
}


//–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––

  render() {
    const { username , password } = this.state;
    return (
            

        <div>
                            <img id="u1_img" class="img " src={fond} style={{position:"relative",left:"400px"}}/>

                <div data-label="Navigation"  id="u129">
                    <Navbar bg="light" expand="lg" style={{height:"50px"}}>
                        <Navbar.Brand onClick={() => this.acceuil()}><img id="u132_img" className="u132_img" src={u132}/></Navbar.Brand>
                        <Navbar.Toggle aria-controls="basic-navbar-nav" />
                        <Navbar.Collapse id="basic-navbar-nav">
                            <Nav className="mr-auto">
                                <Nav.Link href="#u115"><span id="u133">Présentation</span></Nav.Link>
                                <Nav.Link href="#u97"><span id="u134">Equipe</span></Nav.Link>
                                <Nav.Link href="#link"><span id="u131">Contact</span></Nav.Link>
                                <Nav.Link href="#u97"><span id="u137">Spécialités</span></Nav.Link>
                            </Nav>
                        </Navbar.Collapse>
                    </Navbar>
                </div>
        <div className="container-fluid cadre" style={{borderRadius: "10px",padding:"30px",marginTop: "40px",width: "435px",heigh:"410",position: "absolute", left:"70px",top: "130px", marginRight: "310px",borderStyle: "ridge",borderColor: "#D7D7D7", boxShadow:"10px 10px 5px grey"}}>
            <div class="panel panel-default">

                 <div className="panel-body ">
                <center>

{/*––––––––––––––––F  O   R   M–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––*/}
                 <form onSubmit={this.onSubmit} >


{/*–––––––––––––––––––––––*/}<br/><h3>Informations personnelles</h3> <br/>
                <div >
                  <br/>
    {/*––Nom––*/}
                  <div class="form-group">
                    <label for="isbn">Username</label>
                    <input type="text" className="form-control" name="username" value={username} onChange={this.onChange} placeholder="Username" required/>
                  </div>
    {/*––Prenom––*/}
                  <div class="form-group">
                    <label for="title">password</label>
                    <input type="password" class="form-control" name="password" value={password} onChange={this.onChange} placeholder="Password" required/>
                  </div>

    



   
</div>


 {/* */}



  
                {/* 
                <button type="submit" class="btn btn-default" onClick={(e)=>this.alert1(e)}> Ajouter </button>
                */}
                
                <button type="submit" className="btn btn-success" style={{backgroundColor:"#435fbc", borderColor:"#435fbc"}}> Se connecter </button>

              </form>
            </center>


          </div>
        </div>
      </div>
</div>
    );
  }
}

export default Login;

