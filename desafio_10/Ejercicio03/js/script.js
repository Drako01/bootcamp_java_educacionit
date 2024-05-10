document.getElementById('add-category').addEventListener('click', function () {
    const categoryDiv = document.createElement('div');
    categoryDiv.className = 'category';; 
    categoryDiv.innerHTML = `
        <input type="text" class="category-name" placeholder="Nombre de la categoría">
        <input type="number" class="category-percentage" placeholder="Porcentaje"> %
    `;
    document.getElementById('categories').appendChild(categoryDiv);
});

document.getElementById('calculate').addEventListener('click', function () {
    const income = parseFloat(document.getElementById('income').value);
    if (isNaN(income) || income <= 0) {
        alert('Por favor, ingrese un monto válido para los ingresos.');
        return;
    }

    const categoryElements = document.getElementsByClassName('category');
    let totalPercentage = 0;
    const categories = [];

    for (let categoryElement of categoryElements) {
        const name = categoryElement.querySelector('.category-name').value;
        const percentage = parseFloat(categoryElement.querySelector('.category-percentage').value);

        if (!name || isNaN(percentage) || percentage <= 0) {
            alert('Por favor, ingrese un nombre y un porcentaje válido para todas las categorías.');
            return;
        }

        totalPercentage += percentage;
        categories.push({ name, percentage });
    }

    if (totalPercentage !== 100) {
        alert('El total de los porcentajes debe ser igual a 100%.');
        return;
    }

    const resultDiv = document.getElementById('result');
    resultDiv.innerHTML = '<h2>Presupuesto Calculado</h2>';

    categories.forEach(category => {
        const amount = (income * category.percentage) / 100;
        resultDiv.innerHTML += `<p>${category.name}: $${amount.toFixed(2)}</p>`;
    });
});
