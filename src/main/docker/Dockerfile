FROM sequenceiq/spark:1.6.0

ADD flight_small.tar.gz flight_data.tsv

COPY openflight-1.0-SNAPSHOT.jar openflight-1.0-SNAPSHOT.jar

COPY run.sh run.sh

RUN chmod +x run.sh

CMD /run.sh
