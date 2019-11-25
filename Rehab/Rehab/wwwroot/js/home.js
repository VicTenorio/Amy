var modalImg = document.getElementById("img01");
var captionText = document.getElementById("caption");
let modal = document.getElementById('myModal');

function showModal(name) {
    console.log("showModal");
    let image = document.getElementById(name);
    modal.style.display = "block";
    modalImg.src = image.src;
    captionText.innerHTML = image.alt;
}


var span = document.getElementsByClassName("close")[0];
span.onclick = () => {
    modal.style.display = "none";
};

function Aprove(id) {
    $.ajax({
        url: "./AproveProvider",
        async: true,
        contentType: "application/json",
        data: id,
        method: "post",
        complete: (res) => {
            if (res.Status === 200) {
                let tr = document.getElementById(id);
                tr.style.display = "none";
            }
            alert(res.responseJSON.Menssage);
        }
    });
}

function Negate(id) {
    $.ajax({
        url: "./NegateProvider",
        async: true,
        contentType: "application/json",
        data: id,
        method: "post",
        complete: (res) => {
            if (res.status === 200) {
                let tr = document.getElementById(id);
                tr.style.display = "none";
            }
            alert(res.responseJSON.Menssage);
        }
    });
}