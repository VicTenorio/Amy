
let aproveButtons = document.getElementById("AproveButtons");
let confirmAprove = document.getElementById("confirmAprove");
let btnRate = document.getElementById("btnRate");
let btnConfirm = document.getElementById("btnConfirm");
let btnAprovar = document.getElementById("btnAprovar");
let btnReprovar = document.getElementById("btnReprovar");

btnAprovar.onclick = function(){
    confirmation(cancelContract);
}

btnReprovar.onclick = function(){
    confirmation(confirmContract);
}

function confirmation(callback){
    aproveButtons.style.display("none");
    confirmAprove.style.display("block");

    btnRate.onclick = function (){
        aproveButtons.style.display("block");
        confirmAprove.style.display("none");
    };

    btnConfirm.onclick = function(){
        callback(1,1);
    };

}

function confirmContract(idPrestador, idContrado){
    console.log(idPrestador + ' ' +idContrado)
}

function cancelContract(idPrestador, idContrado){
    console.log(idPrestador + ' ' +idContrado)
}