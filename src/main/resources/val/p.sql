CREATE TABLE users
(
    id           SERIAL PRIMARY KEY,
    chat_id      BIGINT UNIQUE NOT NULL,
    name         VARCHAR(256)  NOT NULL,
    current_q_id INTEGER DEFAULT 0
);

CREATE TABLE user_history_array
(
    id            SERIAL PRIMARY KEY,
    history_array INTEGER
);

CREATE TABLE definitions
(
    id          SMALLSERIAL PRIMARY KEY ,
    term    text,
    definition text
);
CREATE TABLE rates
(
    id          SMALLSERIAL PRIMARY KEY ,
    code    text,
    nominal INTEGER,
    description    text,
    ratevalue text
);
SELECT setval('definitions_id_seq', 30, false);
SELECT setval('rates_id_seq', 35, false);

INSERT INTO public.definitions (id, term, definition) VALUES (1, 'test', 'SUCCESS');
INSERT INTO public.definitions (id, term, definition) VALUES (30, 'testeeeeer', 'SUCCESSessssssss');
INSERT INTO public.definitions (id, term, definition) VALUES (2, '## Назовите основные характеристики шаблонов.
', '

+ __Имя__ - все шаблоны имеют уникальное имя, служащее для их идентификации;
+ __Назначение__	назначение данного шаблона;
+ __Задача__ - задача, которую шаблон позволяет решить;
+ __Способ решения__ - способ, предлагаемый в шаблоне для решения задачи в том контексте, где этот шаблон был найден;
+ __Участники__	- сущности, принимающие участие в решении задачи;
+ __Следствия__	- последствия от использования шаблона как результат действий, выполняемых в шаблоне;
+ __Реализация__ - возможный вариант реализации шаблона.
');

INSERT INTO public.definitions (id, term, definition) VALUES (3, 'assets',
'Это все, что имеет какую-либо экономическую ценность, стоимость.');
INSERT INTO public.definitions (id, term, definition) VALUES (4, 'stock',
   'эмиссионная ценная бумага, закрепляющая права ее владельца' ||
   ' (акционера) па получение части прибыли акционерного общества' ||
   ' в виде дивидендов, на участие в управлении акционерным' ||
   ' обществом и на часть имущества, остающегося после его ликвидации.
');
INSERT INTO public.definitions (id, term, definition) VALUES (5, 'capInvestments'
, 'нвестиции в основной капитал (основные средства), в том числе затраты на новое строительство, расширение и т.д.
');
INSERT INTO public.definitions (id, term, definition) VALUES (6, 'disinvestment'
, 'процесс изъятия ранее инвестированного капитала из инвестиционного оборота без последующего его использования' ||
  ' в инвестиционных целях (например, для покрытия убытков предприятия)
');
INSERT INTO public.definitions (id, term, definition) VALUES (7, 'diversification'
, 'сознательный подбор комбинаций инвестиционных проектов, когда достигается не просто их разнообразие,' ||
  ' а определенная взаимозависимость динамики доходов и приемлемый уровень рискованности.
');
INSERT INTO public.definitions (id, term, definition) VALUES (8, 'yield'
, 'способность ценной бумаги приносить положительный финансовый результат в форме прироста капитала.' ||
  'показатель прибыли в процентном или номинальном выражении
');
INSERT INTO public.definitions (id, term, definition) VALUES (9, 'investments'
, 'денежные средства, ценные бумаги, иное имущество, в том числе имущественные права, иные права, имеющие денежную оценку
');
INSERT INTO public.definitions (id, term, definition) VALUES (10, 'ltInvestments'
, 'вложения средств на срок более одного года.
');
INSERT INTO public.definitions (id, term, definition) VALUES (11, 'stInvestments'
, 'вложения капитала на период не более одного года.
');
INSERT INTO public.definitions (id, term, definition) VALUES (12, 'prInvestments'
, 'вложения средств, использование которых приведет к вновь сформированному для инвестиционных целей' ||
  ' капиталу за счет как собственных, так и заемных финансовых ресурсов.
');
INSERT INTO public.definitions (id, term, definition) VALUES (13, 'investor'
, 'субъект инвестиционной деятельности, осуществляющий из собственных или заемных средств финансирование' ||
  ' строительного объекта. Инвестор имеет юридические права па полное распоряжение результатами инвестиций.
');
INSERT INTO public.definitions (id, term, definition) VALUES (14, 'liquidity'
, 'свойство ценной бумаги быть быстро проданной и превращенной в денежные средства' ||
  ' без существенных потерь для держателя
');
INSERT INTO public.definitions (id, term, definition) VALUES (15, 'bond'
, 'эмиссионная ценная бумага, закрепляющая право ее владельца на получение от эмитента облигации' ||
  ' в предусмотренный в ней срок ее номинальной стоимости
');
INSERT INTO public.definitions (id, term, definition) VALUES (16, 'negotiability'
, 'способность ценной бумаги вызывать спрос и предложение (покупаться и продаваться) на рынке,' ||
  ' а иногда - выступать в качестве самостоятельного' ||
  ' платежного инструмента, облегчающего обращение других товаров.
');
INSERT INTO public.definitions (id, term, definition) VALUES (17, 'reinvestment'
, 'повторное использование капитала в инвестиционных целях, полученного путем инвестиционной деятельности.' ||
  'например покупка акций на полученные дивиденды
');
INSERT INTO public.definitions (id, term, definition) VALUES (18, 'capPrice'
, 'величина платы за привлечение любого источника финансирования инвестиций, которая выражается в процентах' ||
  '');
INSERT INTO public.definitions (id, term, definition) VALUES (19, 'payback'
, 'время, за которое поступления от производственной деятельности предприятия покроют затраты па инвестиции.
');
INSERT INTO public.definitions (id, term, definition) VALUES (20, 'dividend'
, 'часть прибыли акционерной компании, распределяемая между ее акционерами в соответствии с количеством и видом акций
');
INSERT INTO public.definitions (id, term, definition) VALUES (21, 'YTM'
, 'ставка внутренней доходности денежного потока по облигации при намерении покупателя удерживать ее до погашения.
');
INSERT INTO public.definitions (id, term, definition) VALUES (22, 'inflation'
, 'процесс обесценивания денег.
');
INSERT INTO public.definitions (id, term, definition) VALUES (23, 'leverage'
, 'использование заемных средств для инвестирования
');
INSERT INTO public.definitions (id, term, definition) VALUES (24, 'option'
, 'договор, который дает покупателю опциона право (но не обязанность) на покупку или продажу базового актива' ||
  ' по установленной цене на определенную дату (дату истечения) или раньше.
');
INSERT INTO public.definitions (id, term, definition) VALUES (25, 'speculator'
, 'инвестор, осознанно принимающий на себя некоторые риски в надежде увеличить свое состояние.
');
INSERT INTO public.definitions (id, term, definition) VALUES (26, 'insider'
, 'Тот, кто имеет доступ к конфиденциальной (инсайдерской) информации.
');
INSERT INTO public.definitions (id, term, definition) VALUES (27, 'spread'
, 'Разница между ценой покупки (цена бид) и продажи (цена аск) акции в один и тот же момент.
');
INSERT INTO public.definitions (id, term, definition) VALUES (28, 'volatility'
, 'Отражает амплитуду колебания цен за определенный промежуток времени.
');
INSERT INTO public.definitions (id, term, definition) VALUES (29, 'ticker'
, 'Короткий набор букв, цифр или символов, который обозначает акции определенной компании.
');


INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (1, 'AUD', 1,
'Австралийский доллар'
, '59.0087');
INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (2, 'AZN', 1,
'Азербайджанский манат'
, '45.6212');
INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (3, 'GBP', 1,
'Фунт стерлингов Соединенного королевства'
, '106.4915');
INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (4, 'AMD', 100,
'Армянских драмов'
, '14.5483');
INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (5, 'BYN', 1,
'Белорусский рубль'
, '29.3400');
INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (6, 'BGN', 1,
'Болгарский лев'
, '47.0730');
INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (7, 'BRL', 1,
'Бразильский реал'
, '13.6390');
INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (8, 'HUF', 100,
'Венгерских форинтов'
, '25.7831');
INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (9, 'HKD', 10,
'Гонконгских долларов'
, '99.6572');
INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (10, 'DKK', 1,
'Датская крона'
, '12.3793');
INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (11, 'USD', 1,
'Доллар США'
, '77.5104');
INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (12, 'EUR', 1,
'Евро'
, '92.0669');
INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (13, 'INR', 10,
'Индийских рупий'
, '10.3436');
INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (14, 'KZT', 100,
'Казахстанских тенге'
, '17.8737');
INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (15, 'CAD', 1,
'Канадский доллар'
, '61.6875');
INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (16, 'KGS', 100,
'Киргизских сомов'
, '91.3893');
INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (17, 'CNY', 1,
'Китайский юань'
, '11.8308');
INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (18, 'MDL', 10,
'Молдавских леев'
, '43.3019');
INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (19, 'NOK', 10,
'Норвежских крон'
, '90.9064');
INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (20, 'PLN', 1,
'Польский злотый'
, '20.3199');
INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (21, 'RON', 1,
'Румынский лей'
, '18.7106');
INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (22, 'XDR', 1,
'СДР (специальные права заимствования)'
, '110.3314');
INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (23, 'SGD', 1,
'Сингапурский доллар'
, '57.7574');
INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (24, 'TJS', 10,
'Таджикских сомони'
, '67.9797');
INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (25, 'TRY', 10,
'Турецких лир'
, '94.5087');
INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (26, 'TMT', 1,
'Новый туркменский манат'
, '22.1775');
INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (27, 'UZS', 10000,
'Узбекских сумов'
, '73.9750');
INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (28, 'UAH', 10,
'Украинских гривен'
, '27.7368');
INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (29, 'CZK', 10,
'Чешских крон'
, '35.3364');
INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (30, 'SEK', 10,
'Шведских крон'
, '90.4460');
INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (31, 'CHF', 1,
'Швейцарский франк'
, '83.7588');
INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (32, 'ZAR', 10,
'Южноафриканских рэндов'
, '52.9472');
INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (33, 'KRW', 1000,
'Вон Республики Корея'
, '68,8871');
INSERT INTO public.rates (id, code, nominal, description, ratevalue) VALUES (34, 'JPY', 100,
'Японских иен'
, '70,8375');





