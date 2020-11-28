#include <iostream>
#include <string>
#include <clocale>
#include <sstream>

using namespace std;

static class XTable;
struct X;
struct XIndicat;

class Changes { // Класс для хранения замен переменных
public:
	static inline string* changes = new string[0]; // Массив замен
	static inline int size = 0; // Количество замен
	static void push(string new_change) { // Добавление новой замены, просходит перевыделение памяти для последующего копирования
		string* copy = new string[size + 1]; // Выделение памяти
		for (int i = 0; i < size; ++i) copy[i] = changes[i]; // Копирование прошлых замен
		copy[size] = new_change; // Запоминание новой замены
		delete[] changes; // Освобождение памяти 
		changes = copy; // Переназначение
		++size; // Увелечение размера
	}
	static void out() { // Вывод замен
		if (size == 0) {
			cout << "Замен нет";
			return;
		}
		cout << "Changes: \n";
		for (int i = 0; i < size; ++i) cout << changes[i] << '\n';
	}
	~Changes() { // Деструктор
		delete[] changes; // Удаление памяти, выделяемой динамически
	}
};

struct XIndicat {
	string num; // Хранит индекс и условные обозначения
	bool normal = false; // Индикатор неотрицательности
	XIndicat(string num) {
		this->num = num;
	}
	XIndicat(int num) {
		ostringstream stream; // Инициализация строкового потока
		stream << num; // Запись в поток
		this->num = stream.str(); // Получение строки
	}
};

class XTable { // Класс таблицы индексов с условными обозначениями
public:
	static inline XIndicat** table; // Статический массив указателей на XIndicat
	static inline int size; // Размер массива
	static void init(int n) { // Инициалиация
		size = n; // Количество параметров
		table = new XIndicat * [n]; // Выделение памяти под массив указателей
		for (int i = 0; i < n; ++i) {
			table[i] = new XIndicat(i + 1); // Присваивание
		}
	}
	static XIndicat* find_indicat(string num) { // Поиск индикаторов по num и возвращают указатель
		for (int i = 0; i < size; ++i) { // Поиск
			if (table[i]->num == num) return table[i];
		}
		return new XIndicat(0); // "Функция должна что-то возвращать, но такой ситуации не произойдет"
	}
	static void push(string num) { // Добавление новой замены, просходит перевыделение памяти для последующего копирования
		XIndicat** copy = new XIndicat * [size + 1]; // Выделение памяти
		for (int i = 0; i < size; ++i) copy[i] = table[i]; // Копирование прошлых записей
		copy[size] = new XIndicat(num); // Запоминание новой замены
		copy[size]->normal = true; // Обозначаем неотрицательность переменной
		delete[] table; // Освобождение памяти
		table = copy; // Переназначение
		++size; // Увелечение размера
	}
};

struct X { // Перемнная с индексом и условными обозначениями и коэффициентами
	XIndicat* indicat; // Указатель на соответствующий индикат
	int val; // Значение коэффициента перед переменной
	X(string num, int val) {
		indicat = XTable::find_indicat(num); // Задание указателя на соответствующий индикат
		this->val = val; // Задание коэффициента
	}
	X(int num, int val) {
		ostringstream stream;
		stream << num;
		indicat = XTable::find_indicat(stream.str());
		this->val = val;
	}
};

struct Limitation { // Ограничение
	int n; // Количество параметров
	X** x; // Массив указателей на переменную
	string sign; // Знак (>=, <=, =)
	int total; // Правая часть ограничения
	bool is_func; // Функция ли это?
	bool for_one_par; // Для одного параметра (x1>=0)
	Limitation(int n, bool is_func) { // Конструктор
		cout << '\n';
		this->is_func = is_func;
		this->n = n;
		x = new X * [n]; // Выделение памяти под массив переменных
		int a; // Для ввода
		int count = 0; // Счетчик ненулевых коэффицентов
		for (int i = 0; i < n; ++i) { // Ввод
			cout << "x" << i + 1 << "=";
			cin >> a;
			if (a != 0) ++count;
			x[i] = new X(i + 1, a);
		}
		for_one_par = (count == 1 ? true : false); 
		if (!is_func) { // Если ограничение, то...
			cout << "sign = "; cin >> this->sign; // Ввод знака
			cout << "total = "; cin >> this->total; // Ввод правой части
		}
		else { // Если функция, то...
			sign = "->";
			do
			{
				cout << "\n1\t->min\n2\t->max\n";
				cin >> this->total; // Ввод
			} while (!(total == 1 || total == 2));
		}
	}
	Limitation(Limitation* lim) { // Конструктор копирования
		this->n = lim->n; 
		this->for_one_par = lim->for_one_par;
		this->is_func = lim->is_func;
		this->sign = "<="; 
		x = new X * [n]; // Выделение памяти под массив
		for (int i = 0; i < n; ++i) {
			x[i] = new X(lim->x[i]->indicat->num, -lim->x[i]->val); // Домножаем на -1
		}
		this->total = -lim->total; // Домножаем на -1
	}
	Limitation(string num) { // Конструктор для задания условия неотрицательности
		this->n = 1; // Количество переменных
		x = new X * [1]; // Выделение памяти под одну переменную
		x[0] = new X(num, 1); // Создание новой переменной
		sign = ">=";
		this->total = 0;
		this->for_one_par = true;
		this->is_func = false;
	}
	void push(X* el) { // Добавление переменной в конец

		X** copy = new X * [n + 1]; // Выделения памяти
		for (int i = 0; i < n; ++i) copy[i] = x[i]; // Копирование раннее-заданных переменных
		copy[n] = new X(el->indicat->num + "\"", -el->val); // Добавление новой переменной в конец
 		copy[n]->indicat->normal = true;
		delete[] x; // Освобождение памяти 
		x = copy; // Замена 
		++n; // Увеличение размера
	}
	void out() { // Вывод строки
		for (int i = 0; i < n; ++i) {
			if (x[i]->val != 0) cout << (x[i]->val < 0 ? "" : "+") << x[i]->val << "x" << x[i]->indicat->num;
		}
		cout << sign;
		if (is_func) cout << (total == 1 ? "min" : "max");
		else cout << total;
		cout << '\n';
	}
	~Limitation() {
		delete[] x; // Освобождение памяти
	}
};

class Task { // Задача целиком
public:
	int param; // Количество параметров
	int kol; // Количество ограничений
	Limitation* function; // Инициализация функции
	Limitation** lim; // Инициализация массива ограничений
	Task() { // Ввод и инициализация
		cout << "\nСколько параметров? - "; cin >> param;
		XTable::init(param); // Создание таблицы, на которую все ссылается
		cout << "\nВведите функцию:";
		function = new Limitation(param, true);
		cout << "Сколько ограничений? - "; cin >> kol;
		lim = new Limitation * [kol]; // Выделение памяти
		for (int i = 0; i < kol; ++i) lim[i] = new Limitation(param, false); // Задание ограничения
	}
	void func_to_standart_form() { // Привидение самой функции
		if (function->total == 1) { //->min
			for (int i = 0; i < function->n; ++i) function->x[i]->val *= -1;
			function->total = 2; //->max
		} 
	}
	void check_non_neg() { // Проверка на неотрицательность
		for (int i = 0; i < kol; ++i) { // Количество ограничений
			if (lim[i]->for_one_par && lim[i]->sign != "=") { // Если выражение заданной переменной и это неравенство
				for (int j = 0; j < lim[i]->n; ++j) { // Количество параметров у i-того ограничения
					if (lim[i]->x[j]->val != 0 && lim[i]->x[j]->indicat->normal == false) { // Если у x есть значение != 0 и оно не нормализованно
						if (lim[i]->sign == ">=") lim[i]->x[j]->indicat->normal = true; // Если знак больше равно, то оно становится нормализованным
						else if (lim[i]->sign == "<=") { // Иначе, то 
							Changes::push("x" + lim[i]->x[j]->indicat->num + "& = -x" + lim[i]->x[j]->indicat->num); // Запись замен (-xn=xn&) 
							XTable::find_indicat(lim[i]->x[j]->indicat->num)->num = lim[i]->x[j]->indicat->num + "&"; //  Изменение таблицы индикатов
							lim[i]->sign = ">=";
						}
					}
				}
			}
		}
		for (int i = 0; i < XTable::size; ++i) { // Проход по таблице
			if (!XTable::table[i]->normal) { // Если элемент таблицы ненормализован, то...
				XTable::push(XTable::table[i]->num + "\""); // Добавляем в конец новый элемент
				for (int j = 0; j < function->n; ++j) { // Цикл прохода по функции
					if (XTable::table[i]->num == function->x[j]->indicat->num && function->x[j]->val != 0) { // Участвует ли эта ненормализованная переменная в строке функции?
						function->push(function->x[j]); // Добавление новой переменной
						break;
					}
				}
				for (int j = 0; j < kol; ++j) { // Цикл прохода по ограничениям
					for (int k = 0; k < lim[j]->n; ++k) { // Цикл прохода по строке
						if (XTable::table[i]->num == lim[j]->x[k]->indicat->num && lim[j]->x[k]->val != 0 && !lim[j]->for_one_par) { // Участвует ли эта ненормализованная переменная в ограничении?
							lim[j]->push(lim[i]->x[j]); // Добавление новой переменной
							break;
						}
					}
				}
				Changes::push("x" + XTable::table[i]->num + " = x" + XTable::table[i]->num + "\' - x" + XTable::table[i]->num + "\""); // Добавление замены
				push(XTable::table[i]->num); // Добавление нового ограничения
				XTable::find_indicat(XTable::table[i]->num)->num += "\'"; // Замена существующего индиката
				XTable::find_indicat(XTable::table[i]->num)->normal = true; // Ставновится нормализованной

			}
		}
	}
	void remake_signs() { // Стандартизируем знаки значений
		for (int i = 0; i < kol; ++i) {
			if (lim[i]->sign != "<=") {
				if (lim[i]->sign == ">=") {
					if (!lim[i]->for_one_par || lim[i]->total != 0) { // Если не условие неотрицательности
						for (int j = 0; j < lim[i]->n; ++j) lim[i]->x[j]->val *= -1; // Умножение коэффициентов на -1
						lim[i]->sign = "<="; // Замена знака
						lim[i]->total *= -1; // Умножение правой части на -1
					}
				}
				else if (lim[i]->sign == "=") {
					lim[i]->sign = "<=";

					Limitation* additional = new Limitation(lim[i]); // Создаем добавочное ограничение
					Limitation** copy = new Limitation * [kol + 1]; // Выделение памяти
					for (int j = 0; j < i; ++j) copy[j] = lim[j]; // Копируем
					copy[i] = additional; // Копируем
					for (int j = i + 1; j < kol + 1; ++j) copy[j] = lim[j - 1]; // Копируем
					delete[] lim; // освобождение памяти
					++kol; // Увеличение ограничений
					lim = copy; // Присваивание
				}
			}
		}
	}
	void to_standart_form() { // Привидение задачи к стандартной форме
		func_to_standart_form();
		check_non_neg();
		remake_signs();

	}
	void push(string num) { // Функция добавления нового ограничения
		Limitation** copy = new Limitation * [kol + 1]; // Выделение памяти
		for (int i = 0; i < kol; ++i) copy[i] = lim[i]; // Копирование ранне-существующих ограничений
		copy[kol] = new Limitation(num + "\""); // Присваивание
		delete[] lim; // Освобождение памяти
		lim = copy; // Присваивание
		++kol; // Увеличение размера
	}
	void out() { // Вывод
		cout << "f: ";
		function->out();
		cout << "\nLimitations:\n";
		for (int i = 0; i < kol; ++i) lim[i]->out();
	}
	~Task() { 
		delete function; // Освобождение памяти
		delete[] lim; // Освобождение памяти
	}
};

int main() {
	setlocale(LC_ALL, "");
	Task task;
	task.to_standart_form();
	cout << '\n';
	task.out();
	cout << '\n';
	Changes::out();
}