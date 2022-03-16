FROM node:16.14.0-alpine3.15

RUN mkdir src
COPY ./app-blog/package.json src
COPY ./app-blog/yarn.lock src
COPY ./app-blog/dist src
WORKDIR /src

RUN adduser --disabled-password appuser
RUN chown -R appuser:appuser /src

USER appuser
RUN yarn install --production
CMD ["yarn", "start"]
