import { BlogPost, blogPosts, User, users } from './data/blog-posts';

export function getAllPosts(): BlogPost[] {
  return blogPosts;
}

export function getUserDetails(userName: string): User {
  return users.find((user) => user.name === userName);
}
