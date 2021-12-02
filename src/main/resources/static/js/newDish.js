let form = document.querySelector('.form-new-dish');
form.onsubmit = (event) =>{
    event.preventDefault();

    // Take info about product
    name = event.target.querySelector('.dish__name').value;
    price = event.target.querySelector('.dish__price').value;
    src = event.target.querySelector('.dish__src').value;
    type = event.target.querySelector('.select__type').value;

    dishDto = {
        "name" : name,
        "price" : price,
        "src" : src,
        "type" : type
    };


    // Add ingredients
    let dishIngredientDto = [];
    let ingredients = document.querySelectorAll('.ingredient');
    for( let ingredient of ingredients){
        obj = {};
        obj.ingredient = ingredient.querySelector('.ingredient__select-ing').value;
        obj.weight = ingredient.querySelector('.ingredient__input-weigth').value;
        dishIngredientDto.push(obj);
    }

    // Create wrapper of info
    dishWrapper = {
        "dishIngredientDto" : dishIngredientDto,
        "dishDto" : dishDto
    }

    let json = JSON.stringify(dishWrapper);
    let request = new XMLHttpRequest();
    request.open('POST', '/rest/dishIngredient/addDish')
    request.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    request.onreadystatechange = function () {
        if (request.readyState == 4 && request.status == 200){
            alert('Отправлено')
        }

    }
    request.send(json);
    console.log(json)

}

const addIngredient = document.querySelector('.addIngredient');
let oldIngredients = [];
addIngredient.onclick = (event) =>{
    event.preventDefault();
    const createIng = document.querySelector('.create-ing');
    const select = document.querySelector('.create-ing__select');
    const selectClone = select.cloneNode(true);
    const selectCloneValue = select.options[select.selectedIndex].value;
    const weigth = document.querySelector('.create-ing__weigth');

    if(weigth.value == '' || weigth.value == 0){
        alert('Введите вес продукта');
        return;
    }
    if(selectClone.options[selectClone.selectedIndex].value == 0) {
        alert('Выберите тип ингредиента');
        return;
    }
    for(let i = 0; i < oldIngredients.length;i++){
        if(oldIngredients[i] == selectCloneValue){
            alert('Ингредиент должен быть уникальным!!!');
            return;
        }
    }
    // create block ingredient
    let divIng = document.createElement('div');
    divIng.className = 'ingredient';

    // create select of ingedients
    let selectIng = selectClone;
    selectIng.className = 'ingredient__select-ing';
    selectIng.name = 'id';
    selectIng.value = selectCloneValue;
    oldIngredients.push(selectCloneValue);

    // create input for weigth
    let inputWeigth = document.createElement('input');
    inputWeigth.className = 'ingredient__input-weigth';
    inputWeigth.name = 'weigth';
    inputWeigth.value = weigth.value;

    // create del btn
    let btnDel = document.createElement('button');
    btnDel.textContent = 'Удалить ингредиент';
    btnDel.className = 'imgredient__del';
    btnDel.onclick = () => {
        btnDel.parentNode.remove();
    }

    divIng.appendChild(selectIng);
    divIng.appendChild(inputWeigth);
    divIng.appendChild(btnDel);
    createIng.after(divIng);


}