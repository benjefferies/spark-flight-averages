#!/bin/bash

# Force name node to leave safe mode
hadoop dfsadmin -safemode leave

# Copy data onto hadoop
hadoop fs -copyFromLocal /flight_data.tsv/flight_small.tsv /

# Submit spark job
spark-submit \
--class AveragePassenger \
--driver-memory 1g \
--executor-memory 1g \
--executor-cores 1 \
/openflight-1.0-SNAPSHOT.jar \
local[*] \
/flight_small.tsv