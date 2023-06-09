package org.example;
// Создать класс Main, который будет содержать метод main для запуска программы.
// Запускаем фрагменты кода последовательно!
//
//        //*Метод 1. Возведение в степень: *//
//        public double power ( double base, double exponent){
//            if (base == 0 && exponent <= 0) {
//                throw new ArithmeticException("Невозможно выполнить операцию");
//            }
//            return Math.pow(base, exponent);
//        }
//        //*Здесь мы можем получить исключение типа ArithmeticException,
//        // если пытаемся возвести ноль в отрицательную степень. *//
//
//
//        //*Метод 2. Получение элемента из списка: *//
//        public String getElement (List < String > list,int index){
//            if (index < 0 || index >= list.size()) {
//                throw new IndexOutOfBoundsException("Индекс за пределами диапазона");
//            }
//            return list.get(index);
//        }
//        //*Здесь мы можем получить исключение типа IndexOutOfBoundsException,
//        // если запрашиваемый индекс находится вне границ списка.
//
//        //* Метод 3. Деление двух числовых массивов: *//
//        public int[] divideArrays ( int[] arr1, int[] arr2){
//            if (arr1.length != arr2.length) {
//                throw new IllegalArgumentException("Длины массивов не совпадают");
//            }
//
//            int[] result = new int[arr1.length];
//            for (int i = 0; i < arr1.length; i++) {
//                if (arr2[i] == 0) {
//                    throw new ArithmeticException("Деление на ноль");
//                }
//                result[i] = arr1[i] / arr2[i];
//            }
//
//            return result;
//        }
        //*Здесь мы можем получить исключения типа IllegalArgumentException,
        // если длины переданных массивов не совпадают, и типа ArithmeticException,
        // если второй массив содержит нулевые элементы. Однако важно отметить,
        // что мы принудительно вызываем исключение RuntimeException
        // (в данном случае - ArithmeticException) при делении на ноль.*//



