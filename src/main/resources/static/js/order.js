let formsProduct = document.querySelectorAll('.product__form');

for (let formProduct of formsProduct) {

    formProduct.onsubmit = (event) => {

        event.preventDefault();
        countOfDishes = event.target.querySelector('.product__countOfDishes').value;

        orderDishDto = {
            'countOfDishes': countOfDishes,
        };

        JSON.stringify(orderDishDto);
        console.log(orderDishDto)
        let json = JSON.stringify(orderDishDto);
        let request = new XMLHttpRequest();
        request.open("POST", "/rest/order/updateOrder");
        request.setRequestHeader('Content-type', 'application/json; charset=utf-8');
        request.send(json);
    }
}