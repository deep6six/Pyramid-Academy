import React from 'react'
import Navbar from './Navbar'

const Content = () => {
  return (
    <>
    <Navbar/>
    <h1>Content Page</h1>
    <div class="container-fluid">
        <article class="blog-post">
            <h2 class="blog-post-title mb-1">Taxonomy</h2>
                <p class="blog-post-meta mb-1">A taxonomy (or taxonomical classification) is a scheme of classification, especially a hierarchical classification, in which things are organized into groups or types. Among other things, a taxonomy can be used to organize and index knowledge (stored as documents, articles, videos, etc.), such as in the form of a library classification system, or a search engine taxonomy, so that users can more easily find the information they are searching for. Many taxonomies are hierarchies (and thus, have an intrinsic tree structure), but not all are.</p>
            <hr/>
        </article>
    </div>
    </>
  )
}

export default Content