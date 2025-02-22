from flask import Flask, jsonify
import nacos

app = Flask(__name__)

# Nacos 配置
NACOS_SERVER = "localhost:8848"
NACOS_USERNAME = "nacos"
NACOS_PASSWORD = "nacos"
SERVICE_NAME = "python-service"
SERVICE_IP = "192.168.1.11"
SERVICE_PORT = 5000

# 初始化 Nacos 客户端
client = nacos.NacosClient(NACOS_SERVER, username=NACOS_USERNAME, password=NACOS_PASSWORD)

# 注册服务到 Nacos
client.add_naming_instance(SERVICE_NAME, SERVICE_IP, SERVICE_PORT)

# 定义一个端点，返回服务信息
@app.route('/info', methods=['GET'])
def get_info():
    return jsonify({
        "service_name": SERVICE_NAME,
        "ip": SERVICE_IP,
        "port": SERVICE_PORT,
        "message": "This is the Python service!"
    })

if __name__ == '__main__':
    app.run(host=SERVICE_IP, port=SERVICE_PORT)
