export MINIO_ACCESS_KEY=steve
export MINIO_SECRET_KEY=steve-boot-launch
nohup ./minio server /home/user/data/minio > /home/user/logs/minio/minio.log 2>&1 &