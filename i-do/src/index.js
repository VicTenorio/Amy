import React from 'react';
import ReactDOM from 'react-dom';
import * as serviceWorker from './serviceWorker';
import {BrowserRouter, Switch, Route} from 'react-router-dom';
import Home from '../src/Pages/home';
import Login from '../src/Pages/login';
import NavbarLogged from '../src/components/navbarLogged';
import ServiceRegister from '../src/Pages/serviceRegister';
import userRegister from './Pages/userRegister';

ReactDOM.render(
        <BrowserRouter>
            <Switch>
                <Route path="/" exact={true} component={Home}/>
                <Route path="/login" component={Login}/>
                <Route path="/cadastroDeUsuario" component={userRegister}/>
                <Route path="/cadastroDeServico" component={ServiceRegister}/>
            </Switch>
        </BrowserRouter>
    , document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
