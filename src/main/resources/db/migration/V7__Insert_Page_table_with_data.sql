drop table if exists page cascade;
create table page
(
    id       bigint not null
        primary key,
    name     varchar(255),
    title    varchar(255),
    content  text,
    css_file varchar(255),
    js_file  varchar(255)
);

alter table page
    owner to root;


INSERT INTO page (id, name, title, content, css_file, js_file) VALUES (1, 'career', 'кар''єра',   '<h2 class="section-item__titls">
                  Компанія ТОВ <span class="company-uppercase"> «Марамакс»</span>
                </h2>

                <div class="section-item__description_p">
                  <p> Дає   унікальну можливість долучитись до  виробництва  гофрокартону, картонно-тарної упаковки та POS матеріалів.</p>  <br>
                  <p> Ми завжди раді новим професіоналам у своїй команді в компанії.</p><br>
                  <p> Ви  можете побудувати успішну кар''єру, а також  розпочати професійне зростання  , маючи невеликий досвід ,  або без досвіду роботи.</p>
                </div>

                <h2 class="section-item__title">
                  Приєднуйтесь до команди професіоналів та розвивайтеся разом з нами!
                </h2>
                  <ul class="list list--first-child">
                    <li class="list__item">
                      Ознайомтесь з актуальними вакансіями.
                    </li>
                    <li class="list__item">
                      Направте резюме через форму «залишити резюме».
                    </li>
                  </ul>

                <h2 class="section-item__title">
                  Якщо у списку вакансій немає тієї, яка відповідає Вашому досвіду та освіті, надішліть своє резюме за вказаною адресою та в темі листа напишіть бажану посаду.
                </h2>
                  <ul class="list list--first-child">
                      <li class="list__item">
                        За потреби складіть супровідний лист, в якому опишіть  свої навички та досвід, а також вкажіть Ваші побажання щодо посади.
                      </li>
                      <li class="list__item">
                        Добре складене резюме та супровідний лист допоможуть нам зрозуміти Ваші очікування та зв''язатися з Вами за наявності вакансії, що відповідає Вашому досвіду, кваліфікації та знанням.
                      </li>
                  </ul>
                  <div>
                    <h2 class="section-item__title">Cлідкуй за актуальними вакансіями:</h2>
                    <a href="https://rabota.ua/ua/company796356">
                      <img src="/img/icons/rabotaua.png" alt="Rabota.ua" class="img-icons-style">
                    </a>
                    <a href="https://www.work.ua/jobs/by-company/1189480/">
                      <img src="/img/icons/work_light_bgs.png" alt="Work.ua" class="img-icons-style">
                    </a>
                  </div>',  '/css/vacancies.css', '/js/vacancies.min.js');


