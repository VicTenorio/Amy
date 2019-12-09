import axios from 'axios';

export default function login (){
const params = {
    email: document.getElementById('txtUser').value,
    senha: document.getElementById('txtPass').value
}

var config = {
    headers: {
        "Access-Control-Allow-Origin": "*",
        "Access-Control-Allow-Headers": "Authorization", 
        "Access-Control-Allow-Methods": "GET, POST, OPTIONS, PUT, PATCH, DELETE" ,
        "Content-Type": "text/xml;charset=UTF-8"  
    }
}

    axios.post('http://ec2-3-87-223-198.compute-1.amazonaws.com:3001/usuario/login', params, config)
        .then(function (response){
        localStorage.setItem("usuario", response.data)
        window.location.href = "/home"
        }
        )
        .catch(function (error) {
        window.location.href = "/home"
            console.log(error);
    })
      
    
}

