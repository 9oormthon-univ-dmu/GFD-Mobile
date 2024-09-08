
const list = document.getElementById('list');
const createBtn = document.getElementById('create-btn');

let todos = [];

createBtn.addEventListener('click', createNewTodo);

function createNewTodo() {
	const item = {
		id: new Date().getTime(),
		text: '',
		complete: false
	}

	todos.unshift(item);

	const { itemEl, inputEl, editBtnEl, removeBtnEl } = createTodoElement(item);

	list.prepend(itemEl);

	inputEl.removeAttribute('disabled');

	inputEl.focus();
	saveToLocalStorage();
}

function createTodoElement(item) {
	const itemEl = document.createElement('div');
	itemEl.classList.add('item');

	const checkbox = document.createElement('input');
	checkbox.type = 'checkbox';
	checkbox.checked = item.complete;

	if (item.complete) {
		itemEl.classList.add('complete');
	}

	const inputEl = document.createElement('input');
	inputEl.type = 'text'
	inputEl.value = item.text;
	inputEl.setAttribute('disabled', '');

	const actionsEl = document.createElement('div');
	actionsEl.classList.add('actions');

	const editBtnEl = document.createElement('button');
	editBtnEl.classList.add('material-icons');
	editBtnEl.innerText = 'edit';

	const removeBtnEl = document.createElement('button');
	removeBtnEl.classList.add('material-icons', 'remove-btn');
	removeBtnEl.innerText = 'remove_circle';

    checkbox.addEventListener('change', () => {
		item.complete = checkbox.checked;

		if (item.complete) {
			itemEl.classList.add('complete');
		} else {
			itemEl.classList.remove('complete');
		}

		saveToLocalStorage();
	});

    inputEl.addEventListener('blur', () => {
		inputEl.setAttribute('disabled', '');
		saveToLocalStorage();
	});

    inputEl.addEventListener('input', () => {
		item.text = inputEl.value;
	});

    editBtnEl.addEventListener('click', () => {
		inputEl.removeAttribute('disabled');
		inputEl.focus();
	});

    removeBtnEl.addEventListener('click', () => {
		todos = todos.filter(t => t.id != item.id);
		itemEl.remove();

		saveToLocalStorage();
	});

	actionsEl.append(editBtnEl); 
	actionsEl.append(removeBtnEl);

	itemEl.append(checkbox);
	itemEl.append(inputEl);
	itemEl.append(actionsEl);

	return { itemEl, inputEl, editBtnEl, removeBtnEl }
}

function saveToLocalStorage() {
	const data = JSON.stringify(todos);

	localStorage.setItem('my_todos', data);
}

function loadFromLocalStorage() {
	const data = localStorage.getItem('my_todos');

	if (data) {
		todos = JSON.parse(data);
	}
}

function displayTodos() {
	loadFromLocalStorage();

	for (let i = 0; i < todos.length; i++) {
		const item = todos[i];

		const { itemEl } = createTodoElement(item);

		list.append(itemEl);
	}
}

displayTodos();