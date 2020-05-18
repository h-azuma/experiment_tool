FROM nginx:1.15.10-alpine

COPY . /usr/share/nginx/html/
EXPOSE 8000
