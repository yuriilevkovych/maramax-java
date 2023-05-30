drop table if exists contact cascade;
create table contact
(
    id         int8 not null,
    name       varchar(255),
    email      varchar(255),
    phone      varchar(255),
    head_name  varchar(255),
    head_email varchar(255),
    head_phone varchar(255),
    primary key (id)
);

INSERT INTO contact (id, name, email, phone, head_name, head_email, head_phone) VALUES (1, 'Логістика та постачання', 'o.nesterchuk@maramax.kiev.ua',   '+38 (097) 005-20-20',  'Мартиненко Оксана',                            '',                             '+38 (097) 036-85-90');
INSERT INTO contact (id, name, email, phone, head_name, head_email, head_phone) VALUES (2, 'Бухгалтерія',             'maramax@bigmir.net',             '+38 (044) 276-25-25',  '',                                             '',                             '');
INSERT INTO contact (id, name, email, phone, head_name, head_email, head_phone) VALUES (3, 'Відділ кадрів',           'o.ostrova@maramax.kiev.ua',      '+38 (067) 507-65-15',  '',                                             '',                             '');
INSERT INTO contact (id, name, email, phone, head_name, head_email, head_phone) VALUES (4, 'Комерційний відділ',      'office@maramax.kiev.ua',         '+38 (097) 005-20-20',  'Кисільов Максим - керівник відділу збуту',     'm.kysilov@maramax.kiev.ua',    '+38 (067) 400-08-52');