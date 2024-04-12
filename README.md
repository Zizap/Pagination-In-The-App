# Example Project Rewritten with Paging3 Library
This repository is created to demonstrate the process of rewriting a multi-module Kotlin project to use the Paging3 library for data pagination. The project implements clean architecture and the MVVM pattern.

## Goal
The goal of this repository is to provide an example of integrating the Paging3 library into an existing project. Here you will find code examples, architectural solutions, and instructions to help you learn how to use Paging3 in your project.

## Modules
The project consists of three main modules:

+ ## App
The App module represents the user interface and implements the presentation layer according to the MVVM architectural pattern. This module contains screens, activities, fragments, views, and other user interface components.

+ ## Domain
The Domain module contains the application's business logic. Here, interfaces and classes describing business models, repositories, use cases, and other components independent of specific implementations are defined.

+ ## Data
The Data module is responsible for interacting with external data sources. It implements repositories, network operations, database operations.

## Used Libraries
+ Room: for working with SQLite database at high-level abstractions.
+ Koin: for dependency injection and managing application components.
+ Retrofit: for handling network requests and APIs.
+ Glide: for loading and displaying images.
+ Coroutines: for asynchronous programming and managing threads.
+ Paging3: for implementing data pagination in the list.
## Running the Project
1. Clone the repository to your computer.
2. Open the project in your preferred development environment.
3. Install the necessary dependencies specified in the build.gradle files of each module.
4. Run the application on a device or emulator.

# Пример переписывания проекта под использование библиотеки Paging3
Этот репозиторий создан с целью демонстрации процесса переписывания многомодульного проекта на языке Kotlin под использование библиотеки Paging3 для реализации пагинации данных. Проект реализует чистую архитектуру и паттерн MVVM.

## Цель
Целью этого репозитория является предоставление примера того, как интегрировать библиотеку Paging3 в существующий проект. Здесь вы найдете примеры кода, архитектурные решения и инструкции, которые помогут вам освоить использование Paging3 в вашем проекте.

## Модули
Проект состоит из трех основных модулей:

+ ## App
Модуль App представляет пользовательский интерфейс и реализует слой представления по архитектурному паттерну MVVM. В этом модуле содержатся экраны, активности, фрагменты, представления и другие компоненты пользовательского интерфейса.

+ ## Domain
Модуль Domain содержит бизнес-логику приложения. Здесь определены интерфейсы и классы, описывающие бизнес-модели, репозитории, use case'ы и другие компоненты, независимые от конкретных реализаций.

+ ## Data
Модуль Data отвечает за взаимодействие с внешними источниками данных. Здесь реализованы репозитории, работа с сетью, базой данных.

## Используемые библиотеки
+ Room: для работы с базой данных SQLite на уровне высокоуровневых абстракций.
+ Koin: для внедрения зависимостей и управления компонентами приложения.
+ Retrofit: для работы с сетевыми запросами и API.
+ Glide: для загрузки и отображения изображений.
+ Coroutines: для асинхронного программирования и управления потоками.
+ Paging3: для реализации пагинации данных в списке.
## Запуск проекта
1. Клонируйте репозиторий на свой компьютер.
2. Откройте проект в выбранной вами среде разработки.
3. Установите необходимые зависимости, указанные в файлах build.gradle каждого модуля.
4. Запустите приложение на устройстве или эмуляторе.
