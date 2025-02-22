const express = require("express");
const NacosNamingClient = require("nacos").NacosNamingClient;

const app = express();
const port = 3000;

// 解析 JSON 请求体
app.use(express.json());

// 定义接口
app.post("/ask", (req, res) => {
  const question = req.body.question;
  const response = `You asked: ${question}. This is the response from Node.js service.`;
  res.json({ response });
});

// 初始化 Nacos 客户端
const nacosClient = new NacosNamingClient({
  serverList: "127.0.0.1:8848", // Nacos 服务器地址
  namespace: "public", // 命名空间
  username: "nacos",
  password: "nacos",
});

// 注册服务
nacosClient.registerInstance("nodes-service", {
  ip: "127.0.0.1",
  port: 3000,
});

console.log("Node.js service registered to Nacos.");

// 启动服务
app.listen(port, () => {
  console.log(`Node.js service is running on http://localhost:${port}`);
});
