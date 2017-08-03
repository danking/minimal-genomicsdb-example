package example

import com.intel.genomicsdb.GenomicsDBFeatureReader

object Hello extends App {

  val loader = "src/main/resources/sample2loader.json"
  val query = "src/main/resources/sample2query.json"
  val workspace = "src/main/resources/tdbworkspace"
  val arrName = "sample2Array"
  val ref = "src/main/resources/Homo_sapiens_assembly19.fasta"

  val gdbReader = new GenomicsDBFeatureReader(loader, workspace, arrName, ref, new htsjdk.variant.vcf.VCFCodec())
  val it = gdbReader.iterator()
  var i = 0
  println("listing records")
  while (it.hasNext()) {
    println("record $i")
    println(it.next())
    i += 1
  }
}
