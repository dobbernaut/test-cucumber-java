import express from 'express';
import { getAllPosts, getUserDetails } from './blog-posts';

const app = express();

app.get('/posts', (req, res) => {
  console.log(`${new Date()} - get posts`);
  res.json(getAllPosts());
});

app.get('/posts/:userName', (req, res) => {
  const userName = req.params.userName;
  console.log(`${new Date()} - get posts for ${userName}`);
  const user = getUserDetails(userName);
  if (user) {
    const posts = getAllPosts().filter((post) => post.id === user.id);
    res.json(posts);
  } else {
    res.status(404).send(`{ Error: No blog posts by ${userName} }`);
  }
});

app.listen(5250, () => {
  console.log('server running in http://localhost:5250');
});
