FROM mcandre/docker-chefdk
MAINTAINER Andrew Pennebaker <andrew.pennebaker@gmail.com>
RUN mkdir /cookbooks
COPY cookbook /cookbooks/cookbook
COPY build/libs/docker-dropwizard-all.jar /docker-dropwizard-all.jar
RUN git config --global user.name name && \
    git config --global user.email user@email.com && \
    sh -c "cd /cookbooks; git init && git add . && git commit -m 'first'"
RUN knife cookbook site install -z java && \
    chef-client -z --runlist 'recipe[cookbook]'
EXPOSE 27017
ENTRYPOINT ["java", "-jar", "/docker-dropwizard-all.jar", "server", "/etc/dropwizard.yml"]
