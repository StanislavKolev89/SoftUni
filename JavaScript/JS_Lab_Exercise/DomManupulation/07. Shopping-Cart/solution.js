function solve() {

   document.getElementsByClassName(`shopping-cart`)[0].addEventListener('click', shoppingCart);
   document.getElementsByClassName('checkout')[0].addEventListener('click', checkout);
   
   let cart = [];
   let output = document.getElementsByTagName('textarea')[0];

   function shoppingCart(ev) {
      if (ev.target.tagName == 'BUTTON' && ev.target.classList.contains('add-product')) {
         let product = ev.target.parentNode.parentNode;
         let productName = product.querySelector('.product-title').textContent;
         let productPrice = Number(product.querySelector('.product-line-price').textContent);

         cart.push({ productName, productPrice });

         output.value += `Added ${productName} for ${productPrice.toFixed(2)} to the cart.\n`
      }

   }
   function checkout() {
      const products = new Set();
      cart.forEach(e => products.add(e.productName));

      const total = cart.reduce((acc, element) => acc + element.productPrice, 0)
      output.value +=`You bought ${[...products.keys()].join(', ')} for ${total.toFixed(2)}.`;
   }
}
