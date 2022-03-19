import { getAllPosts } from '../app/blog-posts';

describe('Blog Posts', () => {
  let blogPosts;

  beforeAll(() => {
    blogPosts = getAllPosts();
  });

  it('should be a list of blog posts', () => {
    expect(blogPosts.length).toBeGreaterThan(0);
  });

  it('should have a unique identifier', () => {
    blogPosts.forEach((post) => {
      expect(post.id).toBeTruthy();
    });
  });
});
