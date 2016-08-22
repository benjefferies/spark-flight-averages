# spark-flight-averages
Spark script to calculate average passengers per flight

A simple spark job implemented in scala to calculate the average number of passengers using open flight data from https://github.com/caesar0301/awesome-public-datasets#transportation using `U.S. Domestic Flights 1990 to 2009` data.

Uses a spark docker container which also runs hadoop.

To build

1. Run mvn install at the root of the project
1. Run `sudo docker build -t passenger-averages .` in `target/docker`
1. Run spark job `sudo docker run -it passenger-average`