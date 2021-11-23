let operatory = ['+','-','*','/'];
let operatoryAll = ['**','%','&&','||','&', '|','^','==','===','>','<'];

function startKalkulator(){
    document.getElementById("kalkulator").style.display = "initial";
    document.getElementById("operatory").style.display = "none";
    document.getElementById("memory").style.display = "none";
    workingOperators();
    allOperators()
}
function doOperatorow(){
    document.getElementById("kalkulator").style.display = "none";
    document.getElementById("operatory").style.display = "initial";
    document.getElementById("memory").style.display = "none";
    let selekt = document.getElementById("selectOperator");
    let spanSelektZmiana = document.getElementById("usunSelect");
    spanSelektZmiana.appendChild(selekt);    
}
function doKalkulatora(){
    document.getElementById("kalkulator").style.display = "initial";
    document.getElementById("operatory").style.display = "none";
    document.getElementById("memory").style.display = "none";
    let selekt = document.getElementById("selectOperator");
    let spanSelektKalkulator = document.getElementById("kalkulatorSelect");
    spanSelektKalkulator.appendChild(selekt);    
}
function doHistorii(){
    document.getElementById("kalkulator").style.display = "none";
    document.getElementById("operatory").style.display = "none";
    document.getElementById("memory").style.display = "initial";
}
function oblicz(){
    let liczba1 = document.getElementById("liczba1").value;
    let liczba2 = document.getElementById("liczba2").value;
    let operator = document.getElementById("selectOperator").value;
    let wynik = liczba1+operator+liczba2;
    wynik = eval(wynik);
    if (wynik){
        document.getElementById("wynik").value = wynik;
        document.getElementById("error").innerHTML = "";
        wstawWiersz(liczba1, operator, liczba2, wynik);
    }else{
        document.getElementById("error").innerHTML = "złe dane lub zły operator";
        document.getElementById("wynik").value = "";
    }
}
function workingOperators(){
    let selectWorkingOperators = document.getElementById("selectOperator");
    for (let operator of operatory){
        let option = document.createElement('option');
        option.value = operator;
        option.innerHTML = operator;
        selectWorkingOperators.appendChild(option);
    }
}
function allOperators(){
    let selectAddOperator = document.getElementById("selectAddOperator");
    for (let operator of operatoryAll){
        let option = document.createElement('option');
        option.value = operator;
        option.innerHTML = operator;
        selectAddOperator.appendChild(option);
    }
}
function dodajOperator(){
    let selectWorkingOperators = document.getElementById("selectOperator");
    let selectAddOperator = document.getElementById("selectAddOperator");
    let option = selectAddOperator.options[selectAddOperator.selectedIndex];
    selectWorkingOperators.appendChild(option);
}
function usunOperator(){
    let selectWorkingOperators = document.getElementById("selectOperator");
    let selectAddOperator = document.getElementById("selectAddOperator");
    let option = selectWorkingOperators.options[selectWorkingOperators.selectedIndex];
    selectAddOperator.appendChild(option);
}
function wstawWiersz(n1,op,n2,result){    
    let N1 = document.createElement('td');
    N1.innerHTML = n1;
    let OP = document.createElement('td');
    OP.innerHTML = op;
    let N2 = document.createElement('td');
    N2.innerHTML = n2;
    let equal = document.createElement('td');
    equal.innerHTML = "=";
    let RES = document.createElement('td');
    RES.innerHTML = result;
    let DELETE = document.createElement('td');
    DELETE.innerHTML = "delete";
    let wiersz = document.createElement('tr');
    wiersz.appendChild(N1);
    wiersz.appendChild(OP);
    wiersz.appendChild(N2);
    wiersz.appendChild(equal);
    wiersz.appendChild(RES);
    wiersz.appendChild(DELETE);
    let tablica = document.getElementById("memoryObliczenia");
    tablica.appendChild(wiersz);
    DELETE.onclick = function(){this.parentElement.remove()};
}