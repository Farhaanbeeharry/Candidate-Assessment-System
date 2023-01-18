FROM docker-remote.artifactory.svc.elca.ch/nginx:alpine
ENV TZ Europe/Zurich

RUN chgrp -R 0 /var/cache/nginx /var/run /var/log/nginx \
 && chmod -R g=u /var/cache/nginx /var/run /var/log/nginx

COPY nginx.conf /etc/nginx/nginx.conf
WORKDIR /usr/share/nginx/html
COPY ./dist ./

USER nginx
