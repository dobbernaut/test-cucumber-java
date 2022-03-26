# Usage:
# ./wait_for_service_ready.sh http://localhost:5025/health/endpoint service-name

URL=$1
SERVICE_NAME=$2
SUCCESS_CODES='200,204'
TIMEOUT=180

echo "Waiting for service ${SERVICE_NAME} to be ready at: ${URL}"

COUNT=0
until [ -z "${SUCCESS_CODES##*$(curl -s -o /dev/null -w "%{http_code}" $URL)*}" ] || [ $COUNT -gt $TIMEOUT ]; do
  echo -n '.'
  sleep 1
  COUNT=$((COUNT+1))
done

if [ $COUNT -gt $TIMEOUT ]; then
  echo -e "\nERROR: Timeout waiting for service ${SERVICE_NAME} at: ${URL}"
  exit 1
else
  echo -e "Service ${SERVICE_NAME} is ready at: ${URL}"
  exit 0
fi
