import axios from 'axios';

export default function login (){
const params = {
    email: document.getElementById('txtUser').value,
    senha: document.getElementById('txtPass').value
}

var config = {
    headers: {
        'Access-Control-Allow-Origin': '*',
        "Access-Control-Allow-Headers": "Authorization", 
        "Access-Control-Allow-Methods": "GET, POST, OPTIONS, PUT, PATCH, DELETE" ,
        "Content-Type": "application/json;charset=UTF-8"  
    }
}

    axios.post('http://localhost:3001/usuario/login', params, config)
        .then(function (response){
        localStorage.setItem("usuario", response.data)
        console.log("sucess")
        }
        )
        .catch(function (error) {
            console.log(error);
    })
      
    
}

