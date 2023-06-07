<ul>
    For installing db locally:
    <li>Install java sdk</li>
    <li>Fill aplication.properties (with ddl-auto=update)</li>
    <li>Install docker</li>
    <li>docker-compose up -d</li>
    <li>docker exec -it maramax-java-db-1 bash</li>
    <li>psql db_name, \c, \d, insert....</li>
    <li>Deploy: ./scripts/deploy.sh</li>
    <li>Logs: tail -f /home/maramax/log.txt</li>
    <li>upload images: scp img.zip root@SERVER_IP:~/updoads</li>
    <li>To see Log: tail -f /home/maramax/log.txt</li>
    <li>certbot certificates</li>
</ul>

<h2>Authorization:</h2>
https://www.javaguides.net/2018/10/user-registration-module-using-springboot-springmvc-springsecurity-hibernate5-thymeleaf-mysql.html