let cart = [];

    async function getMenus() {
        const res = await fetch('http://localhost:8080/api/menus/getall');
        const menus = await res.json();
        const list = document.getElementById('menuList');
        list.innerHTML = '';
        menus.forEach(menu => {
            const li = document.createElement('li');
            const ul = document.createElement('ul');
            ul.className = 'menu-details';
            ul.style.listStyleType = 'disc';

            const nameLi = document.createElement('li');
            nameLi.textContent = `Name: ${menu.itemName}`;
            ul.appendChild(nameLi);

            const descLi = document.createElement('li');
            descLi.textContent = `Description: ${menu.description}`;
            ul.appendChild(descLi);

            const priceLi = document.createElement('li');
            priceLi.textContent = `Price: Rs. ${menu.price}`;
            ul.appendChild(priceLi);

            const categoryLi = document.createElement('li');
            categoryLi.textContent = `Category: ${menu.category}`;
            ul.appendChild(categoryLi);

            li.appendChild(ul);
            const addBtn = document.createElement('button');
            addBtn.className = 'add-btn';
            addBtn.textContent = 'Add to Cart';
            addBtn.onclick = () => addToCart(menu);
            li.appendChild(addBtn);
            list.appendChild(li);
        });
    }

    function addToCart(menu) {
        const idx = cart.findIndex(item => item.id === menu.id);
        if (idx > -1) {
            cart[idx].qty += 1;
        } else {
            cart.push({
                id: menu.id,
                itemName: menu.itemName,
                price: menu.price,
                qty: 1
            });
        }
        updateCart();
    }

    function updateCart() {
        const cartList = document.getElementById('cartList');
        const cartTotal = document.getElementById('cartTotal');
        cartList.innerHTML = '';
        let total = 0;
        if (cart.length === 0) {
            cartList.innerHTML = '<div class="empty-cart">Cart is empty</div>';
        } else {
            cart.forEach(item => {
                total += item.price * item.qty;
                const li = document.createElement('li');
                li.innerHTML = `<span class="cart-item-name">${item.itemName}</span>
                    <button onclick="changeQty('${item.id}', -1)">-</button>
                    <span class="cart-qty">${item.qty}</span>
                    <button onclick="changeQty('${item.id}', 1)">+</button>
                    <span> Rs. ${item.price * item.qty}</span>`;
                cartList.appendChild(li);
            });
        }
        cartTotal.textContent = `Total: Rs. ${total}`;
    }

    function changeQty(id, delta) {
        const idx = cart.findIndex(item => item.id == id);
        if (idx > -1) {
            cart[idx].qty += delta;
            if (cart[idx].qty <= 0) {
                cart.splice(idx, 1);
            }
            updateCart();
        }
    }

   async function checkout() {
    if (cart.length === 0) return;
    // Calculate total amount
    let total = cart.reduce((sum, item) => sum + item.price * item.qty, 0) * 100; // in paise
    let amount = total;
    fetch('http://localhost:8080/api/payment/create-order', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ amount: total })
            })
                .then(response => response.json())
                .then(order => {
                    const options = {
                        "key": "rzp_test_RJzL1vYgKXXRyC",
                        "amount": order.amount,
                        "currency": order.currency,
                        "name": "Your Company",
                        "description": "Payment for your product",
                        "order_id": order.id,
                        "callback_url": "http://localhost:8080/api/payment/payment-callback",
                        "prefill": {
                            "name": "User Name",
                            "email": "user@example.com",
                        }
                    };
                    const rzp1 = new Razorpay(options);
                    rzp1.open();
                });

<!--    // Call backend to create order-->
<!--    const response = await fetch('http://localhost:8080/api/payment/create-order', {-->
<!--        method: 'POST',-->
<!--        headers: { 'Content-Type': 'application/json' },-->
<!--        body: JSON.stringify({ amount: total })-->
<!--    });-->
<!--    const data = await response.json();-->

<!--    var options = {-->
<!--        "key": "rzp_test_RJzL1vYgKXXRyC", // Enter the Key ID generated from the Dashboard-->
<!--        "amount": order.amount, // Use calculated amount-->
<!--        "currency": "order.currency", // Use currency from order-->
<!--        "name": "Acme Corp",-->
<!--        "description": "Test Transaction",-->
<!--        "image": "https://example.com/your_logo",-->
<!--        "order_id": order.orderId, // Use correct property name (case-sensitive)-->
<!--        "callback_url": "http://localhost:8080/api/payment/payment-callback",-->
<!--        "prefill": {-->
<!--            "name": "Gaurav Kumar",-->
<!--            "email": "gaurav.kumar@example.com",-->
<!--            "contact": "+919876543210"-->
<!--        },-->
<!--        "notes": {-->
<!--            "address": "Razorpay Corporate Office"-->
<!--        },-->
<!--        "theme": {-->
<!--            "color": "#3399cc"-->
<!--        }-->
<!--    };-->
<!--    var rzp1 = new Razorpay(options);-->
<!--    rzp1.open();-->
}

    window.onload = function() {
        getMenus();
        updateCart();
    };