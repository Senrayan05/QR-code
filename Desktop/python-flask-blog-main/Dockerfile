FROM python:3.8-slim

WORKDIR /app
COPY . /app/
EXPOSE 8888

RUN pip install --no-cache-dir -r /app/requirements.txt

CMD ["python", "/app/app.py"]
