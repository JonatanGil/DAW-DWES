
window.onload = cargar;


function cargar() {
    fetch("../php/abstraccion_datos.php")
        .then(function (res) {
            if (res.status >= 200 && res.status < 300) {
                return res.json();
            }
        }).then(resjson => {
            console.log(resjson);
        }).catch(function (err) {
        });
}

