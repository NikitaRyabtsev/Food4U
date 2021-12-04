
const btn = document.querySelectorAll('.product__submit > span');

for (let i = 0; i < btn.length; i++) {

    btn[i].addEventListener('click', function() {
        this.innerHTML =
            (this.innerHTML === 'Добавить в корзину') ? this.innerHTML = 'Добавлено в корзину' : this.innerHTML = 'Добавлено в корзину';
    })

}



const dishBtn = document.querySelector('.dishBtn > span');
dishBtn.addEventListener('click', function() {
    dishBtn.innerHTML =
        (dishBtn.innerHTML === 'Добавить в корзину') ? dishBtn.innerHTML = 'Добавлено в корзину' : dishBtn.innerHTML = 'Добавлено в корзину';
})