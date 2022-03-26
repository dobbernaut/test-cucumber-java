FROM node:16.14.0-alpine3.15

RUN mkdir src
COPY ./service-mock/package.json src
COPY ./service-mock/yarn.lock src
COPY ./service-mock/dist src
WORKDIR /src

RUN adduser --disabled-password appuser
RUN chown -R appuser:appuser /src

USER appuser
RUN yarn install --production
CMD ["yarn", "start"]
