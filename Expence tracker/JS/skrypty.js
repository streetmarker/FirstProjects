let curr = ["PLN", "$", "€"];
let count = 1;

start = () => {
    workingCurrency();
}

workingCurrency = () => {
    let selectWorkingCurrency = document.getElementById("selectCurrency");
    for (let cu of curr){
        let option = document.createElement('option');
        option.value = cu;
        option.innerHTML = cu;
        selectWorkingCurrency.appendChild(option);
    }
}

add = () => {
    let tit = document.getElementById("expense").value;
    let amm = document.getElementById("ammount").value;
    let currency = document.getElementById("selectCurrency").value;
    let dat = document.getElementById("date").value;

    let box = document.createElement('td');
    box.innerHTML = count++;
    let titTd = document.createElement("td");
    titTd.innerHTML = tit;
    let currTd = document.createElement("td");
    currTd.innerHTML = currency;//
    let ammTD = document.createElement("td");
    ammTD.innerHTML = amm;
    let dateTD = document.createElement("td");
    dateTD.innerHTML = dat;
    let DELETE = document.createElement("td");
    DELETE.innerHTML = "delete";

    let row = document.createElement("tr");
    let board = document.getElementById("records");

    row.appendChild(box);
    row.appendChild(titTd);
    row.appendChild(ammTD);
    row.appendChild(currTd);
    row.appendChild(dateTD);
    row.appendChild(DELETE)
    board.appendChild(row);
    
    DELETE.onclick = () => {this.parentElement.remove()};

}