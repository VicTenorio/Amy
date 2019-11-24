export default function uploadFile(){
    const file = document.getElementById("fileInput").files[0];
    document.getElementById("foto").src = window.URL.createObjectURL(file);
}