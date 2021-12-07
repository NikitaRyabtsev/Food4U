let formsProduct = document.querySelectorAll('.product__form');

for(let formProduct of formsProduct){
    formProduct.onsubmit = (event) =>{
        event.preventDefault();

        id = event.target.querySelector('.product__id').value;
        countOfDishes = event.target.querySelector('.product__countOfDishes').value;
        price = event.target.querySelector('.product__price').value;
        console.log(price);

        orderDishDto = {
            'dish': id,
            'countOfDishes': countOfDishes,
            'price' : price,
        };

        JSON.stringify( orderDishDto);
        console.log( orderDishDto)
        let json = JSON.stringify(orderDishDto);
        let request = new XMLHttpRequest();
        request.open("POST", "/rest/order/newOrder");
        request.setRequestHeader('Content-type', 'application/json; charset=utf-8');
        request.send(json);
    }
}



