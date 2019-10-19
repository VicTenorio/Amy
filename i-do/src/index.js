import React from 'react';
import ReactDOM from 'react-dom';
import * as serviceWorker from './serviceWorker';
import {BrowserRouter, Switch, Route} from 'react-router-dom';
import Home from '../src/Pages/home';
import Login from '../src/Pages/login';
import ServiceRegister from '../src/Pages/serviceRegister';
import MeusServicos from '../src/Pages/my-services';
import UserRegister from '../src/Pages/userRegister';
import ScheduledServices from '../src/Pages/scheduledServices';

ReactDOM.render(
        <BrowserRouter>
            <Switch>
                <Route path="/" exact={true} component={Home}/>
                <Route path="/login" component={Login}/>
                <Route path="/cadastroDeUsuario" component={UserRegister}/>
                <Route path="/cadastroDeServico" component={ServiceRegister}/>
                <Route path="/meusServicos" component={MeusServicos}/>
                <Route path="/servicosAgendados" component={ScheduledServices}/>
            </Switch>
        </BrowserRouter>
    , document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
