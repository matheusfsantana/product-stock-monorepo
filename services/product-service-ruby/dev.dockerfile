FROM ruby:3.4.2

RUN apt update -y

WORKDIR /app

COPY Gemfile . 
COPY Gemfile.lock .

RUN bundle install

COPY . .

CMD [ "bin/setup" ]