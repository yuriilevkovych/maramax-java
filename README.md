<ul>
    For installing db locally:
    <li>Install docker</li>
    <li>docker-compose up -d</li>
    <li>docker exec -it maramax-java-db-1 bash</li>
    <li>Create db and insert user-admin for auth</li>
    <li>Deploy: ./scripts/deploy.sh</li>
    <li>Logs: tail -f /home/maramax/log.txt</li>
    <li>upload images: scp img.zip root@SERVER_IP:~/updoads</li>
</ul>

<h2>Authorization:</h2>
https://www.javaguides.net/2018/10/user-registration-module-using-springboot-springmvc-springsecurity-hibernate5-thymeleaf-mysql.html
